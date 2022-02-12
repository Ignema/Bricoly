import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router'
import { Auth } from '../models/auth/auth'
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private _registerProviderUrl = `${environment.apiUrl}/register/provider`
  private _registerCustomerUrl = `${environment.apiUrl}/register/customer`
  private _loginUrl = `${environment.apiUrl}/login`

  private userSubject: BehaviorSubject<Auth | null>;
  public currentUser: Observable<any>;

  constructor(private http: HttpClient, private router: Router) {
    this.userSubject = new BehaviorSubject<Auth | null>(
      JSON.parse(localStorage.getItem('currentUser') as string)
    );
    this.currentUser = this.userSubject.asObservable();
  }

  registerProvider(user: any): Observable<any> {
    console.log(user)
    return this.http.post<any>(this._registerProviderUrl, user)
  }

  registerCustomer(user: any): Observable<any> {
    return this.http.post<any>(this._registerCustomerUrl, user)
  }

  login(email: string, password: string) {
    return this.http
      .post<any>(this._loginUrl, { email, password })
      .pipe(
        map(({token, type}) => {
          let user: Auth = {
            email: email,
            token: token,
            type: type
          };
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.userSubject.next(user);
          return user;
        })
      );
    }

  logout() {
    localStorage.removeItem('currentUser');
    this.userSubject.next(null);
    this.router.navigate(['/']);
  }

  public getCurrentUser(): Auth | null {
    return this.userSubject.value;
  }
}