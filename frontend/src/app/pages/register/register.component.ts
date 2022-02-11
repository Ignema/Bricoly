import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private auth: AuthentificationService, private router: Router) { }

  ngOnInit(): void {
  }

  onNgSubmit(form: NgForm): void {
    const user = {
      "first_name": form.value['first-name'],
      "last_name": form.value['last-name'],
      "email": form.value.email,
      "birthday": new Date(form.value.birthday),
      "location": form.value.location,
      "password": form.value.password
    };
    if(form.value.type === 'provider') {
      this.auth.registerProvider(user).subscribe({
        next: () => {
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.log(error);
        },
      });
    } else {
      this.auth.registerCustomer(user).subscribe({
        next: () => {
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
  }
}
