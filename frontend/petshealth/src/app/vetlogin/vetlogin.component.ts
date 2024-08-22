import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-vetlogin',
  templateUrl: './vetlogin.component.html',
  styleUrls: ['./vetlogin.component.scss']
})
export class VetloginComponent {
  constructor(private apiRequestService:ApirequestService){}
  loginFormGroup: FormGroup = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  collectFormData() {
    this.apiRequestService.loginVet(this.loginFormGroup.value);
  }

}

