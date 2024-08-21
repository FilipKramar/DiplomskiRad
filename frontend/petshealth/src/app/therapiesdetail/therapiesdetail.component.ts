import { Component, OnInit } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-therapiesdetail',
  templateUrl: './therapiesdetail.component.html',
  styleUrls: ['./therapiesdetail.component.scss']
})
export class TherapiesdetailComponent implements OnInit {

    therapy: any;
  
    constructor(private apiRequestService: ApirequestService) { }
  
    ngOnInit(): void {
      this.apiRequestService.getTherapiesDetails().subscribe(
        (data) => {
          this.therapy = data;
        },
        (error) => {
          console.error('Error fetching therapy details', error);
        }
      );
    }
  
  }
  