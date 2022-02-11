import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardComponent } from './dashboard.component';
import { ProfileComponent } from './panels/profile/profile.component';
import { OffersComponent } from './panels/offers/offers.component';
import { JobsComponent } from './panels/jobs/jobs.component';
import { OfferItemComponent } from './components/offer-item/offer-item.component';
import { JobItemComponent } from './components/job-item/job-item.component';

@NgModule({
  declarations: [
    DashboardComponent,
    ProfileComponent,
    OffersComponent,
    JobsComponent,
    OfferItemComponent,
    JobItemComponent
  ],
  imports: [
    CommonModule
  ]
})
export class DashboardModule { }
