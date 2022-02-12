import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  provider!: any;

  constructor() { }

  ngOnInit(): void {
    this.provider = history.state.data;
  }

  public getProviderName(): string {
    return this.provider.user.first_name + " " + this.provider.user.last_name;
  }

  public getProviderAge(): any {
    const today = new Date();
    const birthDate = new Date(this.provider.user.birthday);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    return age;
  }

}
