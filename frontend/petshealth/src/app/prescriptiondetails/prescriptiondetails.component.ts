import { Component, OnInit } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-prescriptiondetails',
  templateUrl: './prescriptiondetails.component.html',
  styleUrls: ['./prescriptiondetails.component.scss']
})
export class PrescriptiondetailsComponent implements OnInit {

  prescription: any;

  constructor(private apiRequestService: ApirequestService) { }

  ngOnInit(): void {
    this.apiRequestService.getPrescriptionDetails().subscribe(
      (data) => {
        this.prescription = data;
      },
      (error) => {
        console.error('Error fetching visit details:', error);
      }
    );
  }

}
