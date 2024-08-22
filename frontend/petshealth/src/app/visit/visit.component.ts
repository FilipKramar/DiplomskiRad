import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.scss']
})
export class VisitComponent {
  visits: any;

  constructor(private apiRequestService: ApirequestService, private router: Router) {}

  ngOnInit(): void {
    this.apiRequestService.getPetsVisits().subscribe(
      (response) => {
        this.visits = response;
      },
      (error) => {
        alert('Unable to retrieve any visits.');
      }
    );
  }

  navigateToVisitDetails(visitId: number): void {
    sessionStorage.setItem('visitId', visitId.toString());
    this.router.navigate(['/home/visitdetails']);
  }

}