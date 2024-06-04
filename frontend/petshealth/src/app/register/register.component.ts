import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApirequestService } from '../services/apirequest.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  constructor(private apiRequestService:ApirequestService){}
  registerFormGroup: FormGroup = new FormGroup({
    oib: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    name: new FormControl('', Validators.required),
    surname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
  });
  

  collectFormData() {
    this.apiRequestService.registerUser(this.registerFormGroup.value);
  }
}
