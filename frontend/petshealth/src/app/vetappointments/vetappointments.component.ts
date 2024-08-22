import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-vetappointments',
  templateUrl: './vetappointments.component.html',
  styleUrls: ['./vetappointments.component.scss']
})
export class VetappointmentsComponent {
  visits: any;
  constructor(private apiRequestService:ApirequestService,private router: Router){}
  ngOnInit(): void {
    this.apiRequestService.getVetsAppointments().subscribe(
      (response) => {
        this.visits=response;
      },
      (error) => {
        alert('Cant find any pets');
      }
    );
  }

  navigateToVisitDetails(visitId: number,petId:number): void {
    sessionStorage.setItem('visitId', visitId.toString());
    sessionStorage.setItem('petId', petId.toString());
    this.router.navigate(['/home/visitdetails']);
  }


}