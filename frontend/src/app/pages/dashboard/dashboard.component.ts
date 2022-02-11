import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  currentPanel: string = 'profile';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public selectPanel(panel: string): void {
    this.currentPanel = panel;
  }

  public logout() {
        this.router.navigate(['/']);
  };

}
