import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/models/category/category';
import { Provider } from 'src/app/models/provider/provider';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  
  public categories!: Category[];
  public offers!: any[];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Category[]>(`${environment.apiUrl}/category`).subscribe(categories => this.categories = categories);
    this.http.get<Provider[]>(`${environment.apiUrl}/provider`).subscribe(providers => this.offers = providers.map(provider => provider.offers.map(offer => ({...offer, "provider_name": `${provider.user.first_name} ${provider.user.last_name}`, "provider_id": provider.provider_id}))).flat());
  }

}
