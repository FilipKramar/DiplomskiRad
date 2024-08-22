import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-registerpet',
  templateUrl: './registerpet.component.html',
  styleUrls: ['./registerpet.component.scss']
})
export class RegisterpetComponent implements OnInit {
  createPetFormGroup: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private apiRequestService: ApirequestService
  ) {
    this.createPetFormGroup = new FormGroup({
      species: new FormControl('', Validators.required),
      breed: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      microchipNumber: new FormControl('', Validators.required),
      userId: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    const userId = sessionStorage.getItem('userid');
    if (userId) {
      this.createPetFormGroup.patchValue({ userId: +userId });
    }
  }

  collectFormData() {
    this.apiRequestService.registerAPet(this.createPetFormGroup.value);
  }
}
