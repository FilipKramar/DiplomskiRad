import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-selectpet',
  templateUrl: './selectpet.component.html',
  styleUrls: ['./selectpet.component.scss']
})
export class SelectpetComponent {
  usersPet: any;
  constructor(private apiRequestService:ApirequestService,private router: Router){}
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

  navigateToHome(petId: number): void {
    sessionStorage.setItem('petId', petId.toString());
    this.router.navigate(['/home/']);
  }

}
