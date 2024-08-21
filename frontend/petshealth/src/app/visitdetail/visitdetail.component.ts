import { Component, OnInit } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';


@Component({
  selector: 'app-visitdetail',
  templateUrl: './visitdetail.component.html',
  styleUrls: ['./visitdetail.component.scss']
})
export class VisitdetailComponent implements OnInit {

  visit: any;
  prescriptions: any[] = [];
  therapies: any[] = [];
  

  constructor(private apiRequestService: ApirequestService) { }

  ngOnInit(): void {
    this.apiRequestService.getVisitDetails().subscribe(
      (data) => {
        this.visit = data.visit;
        this.prescriptions = data.prescriptions;
        this.therapies = data.therapies;
      },
      (error) => {
        console.error('Error fetching visit details:', error);
      }
    );
  }

}
