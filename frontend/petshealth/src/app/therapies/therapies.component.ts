import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-therapies',
  templateUrl: './therapies.component.html',
  styleUrls: ['./therapies.component.scss']
})
export class TherapiesComponent {

  therapies: any;
  constructor(private apiRequestService:ApirequestService,private router: Router){}
  ngOnInit(): void {
    this.apiRequestService.getPetsTherapies().subscribe(
      (response) => {
        this.therapies=response;
      },
      (error) => {
        alert('Cant find any pets');
      }
    );
  }

  navigatetoTherapyDetails(therapyId: number): void {
    sessionStorage.setItem('therapyId', therapyId.toString());
    this.router.navigate(['/home/therapiesdetails']);
  }

}
