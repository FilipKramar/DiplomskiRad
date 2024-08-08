import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-prescriptions',
  templateUrl: './prescriptions.component.html',
  styleUrls: ['./prescriptions.component.scss']
})
export class PrescriptionsComponent {
  medications: any;
  constructor(private apiRequestService:ApirequestService,private router: Router){}
  ngOnInit(): void {
    this.apiRequestService.getPetsPrescriptions().subscribe(
      (response) => {
        this.medications=response;
      },
      (error) => {
        alert('Cant find any pets');
      }
    );
  }

  navigatetoPrescriptionDetails(prescriptionId: number): void {
    sessionStorage.setItem('prescriptionId', prescriptionId.toString());
    this.router.navigate(['/home/']);
  }


}
