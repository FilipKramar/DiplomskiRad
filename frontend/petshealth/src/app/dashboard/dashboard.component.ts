import { Component } from '@angular/core';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
  tasks: any;
  userstories: any;
  alltasks: any;
  constructor() {}

  ngOnInit(): void {
    
  }
}
