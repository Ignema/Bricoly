import { Component, OnInit } from '@angular/core';
import { SimpleModalService } from "ngx-simple-modal";
import { ModalComponent } from '../../components/modal/modal.component';


@Component({
  selector: 'app-dashboard-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent  implements OnInit {


  constructor(private simpleModalService: SimpleModalService) { }

  ngOnInit(): void {
  }

  showConfirm() {
    this.simpleModalService.addModal(ModalComponent, {
          title: 'New Offer',
          message: 'Do you want to add a new offer?'
        })
        // .subscribe((isConfirmed)=>{
        //     //We get modal result
        //     if(isConfirmed) {
        //         alert('Working on it!');
        //     }
        //     else {
        //         alert('Rip');
        //     }
        // });
}

}
