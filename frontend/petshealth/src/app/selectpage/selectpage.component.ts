import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-selectpage',
  templateUrl: './selectpage.component.html',
  styleUrls: ['./selectpage.component.scss']
})
export class SelectpageComponent {
  usersPet: any;
  constructor(private apiRequestService:ApirequestService){}
  ngOnInit(): void {
    this.apiRequestService.getUsersPets().subscribe(
      (response) => {
        console.log('Pets data:', response);
        this.usersPet=response;
      },
      (error) => {
        alert('Cant find any pets');
      }
    );
  }

}
