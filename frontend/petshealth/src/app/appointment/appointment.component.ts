import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent implements OnInit {
  appointmentFormGroup: FormGroup;
  veterinarians: any[] = [];
  singlePet: any; // Single pet object

  constructor(
    private fb: FormBuilder,
    private apiRequestService: ApirequestService
  ) {
    this.appointmentFormGroup = this.fb.group({
      vetId: [null],
      petId: [null],
      visitDate: [null],
      visitTime: [null]
    });
  }

  ngOnInit(): void {
    this.loadVeterinarians();
    this.loadSinglePet();
  }

  loadVeterinarians(): void {
    this.apiRequestService.getVets().subscribe(data => {
      this.veterinarians = data;
    });
  }

  loadSinglePet(): void {
    this.apiRequestService.getPet().subscribe(data => {
      this.singlePet = data;
      if (this.singlePet) {
        this.appointmentFormGroup.get('petId')?.setValue(this.singlePet.id);
      }
    });
  }

  submitAppointment(): void {
    this.apiRequestService.scheduleAnVisit(this.appointmentFormGroup.value);
  }
}
