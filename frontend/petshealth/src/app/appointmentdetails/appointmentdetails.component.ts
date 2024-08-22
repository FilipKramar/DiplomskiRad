import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApirequestService } from '../services/apirequest.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-appointmentdetails',
  templateUrl: './appointmentdetails.component.html',
  styleUrls: ['./appointmentdetails.component.scss']
})
export class AppointmentdetailsComponent implements OnInit {
  appointmentDetailsFormGroup: FormGroup;
  therapies: any[] = [];
  prescriptions: any[] = [];
  singlePet: any;

  constructor(
    private fb: FormBuilder,
    private apiRequestService: ApirequestService,
    private location: Location
  ) {
    this.appointmentDetailsFormGroup = this.fb.group({
      prescriptionId: [[]],
      therapyId: [[]]
    });
  }

  ngOnInit(): void {
    this.loadTherapies();
    this.loadPrescriptions();
    this.loadSinglePet();
  }

  loadTherapies(): void {
    this.apiRequestService.getTherapies().subscribe(data => {
      this.therapies = data;
    });
  }

  loadPrescriptions(): void {
    this.apiRequestService.getPrescriptions().subscribe(data => {
      this.prescriptions = data;
    });
  }

  loadSinglePet(): void {
    this.apiRequestService.getPet().subscribe(data => {
      this.singlePet = data;
    });
  }

  submitAppointmentDetails(): void {
    this.apiRequestService.addAppointmentDetails(this.appointmentDetailsFormGroup.value);
    this.location.back();
  }
}
