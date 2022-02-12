import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Detail } from 'src/app/models/detail/detail';
import { Provider } from 'src/app/models/provider/provider';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  offer!: any;

  provider!: any;
  days!: string;
  details!: string[]; 

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
      // Get Offer
      this.offer = history.state.data;
      console.log(this.offer);

      // Get Provider & Build days string
      this.http.get<Provider>(`${environment.apiUrl}/provider/${this.offer.provider_id}`).subscribe(provider => {
        this.provider = provider;
        this.days = provider.days.map(day => day.name).join(", ");
        this.details = this.offer.details.map((detail: Detail) => detail.name);
      });
  }
}
