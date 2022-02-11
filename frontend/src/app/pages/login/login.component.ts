import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthentificationService, private router: Router) { }

  ngOnInit(): void {
  }

  onNgSubmit(form: NgForm): void {
    this.auth.login(form.value.email, form.value.password).subscribe({
      next: (user) => {
        if(user.type === 'provider') {
          this.router.navigate(['/dashboard']);
        } else {
          this.router.navigate(['/catalog']);
        }
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

}
