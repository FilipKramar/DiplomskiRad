import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../environment/environment';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApirequestService {

  constructor(private http: HttpClient, private router: Router) {}

  loginUser(data: any) {
    const url = `${apiUrl.key}users`;
    this.http.post<number>(url, data).subscribe(
      (Id: number) => {
        this.router.navigate(['/home/dashboard']);
        sessionStorage.setItem('isUser', 'true');
        sessionStorage.setItem('userid', Id.toString());
      },
      (error) => {
        alert('Wrong email or password');
      }
    );
  }
  loginVet(data: any) {
    const url = `${apiUrl.key}vet`;
    this.http.post<number>(url, data).subscribe(
      (Id: number) => {
        this.router.navigate(['/home/']);
        sessionStorage.setItem('isUser', 'false');
        sessionStorage.setItem('vetid', Id.toString());
      },
      (error) => {
        alert('Wrong email or password or not a vet');
      }
    );
  }
  registerUser(data: any) {
    const url = `${apiUrl.key}users/register`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('User created sucessfully');
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Cant register');
      }
    );
  }
  getUsersPets() {
    const userId = sessionStorage.getItem('userid');
    const url = `${apiUrl.key}users/pets/${userId}`;
    return this.http.get<void>(url);
  }

  getVetsAppointments() {
    const vetid = sessionStorage.getItem('vetid');
    const url = `${apiUrl.key}visit/vet/${vetid}`;
    return this.http.get<void>(url);
  }

  registerAPet(data: any) {
    const url = `${apiUrl.key}pets`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('Pet created sucessfully');
        this.router.navigate(['/home/dashboard/']);
      },
      (error) => {
        alert('Cant create pet');
      }
    );
  }
  getPetsPrescriptions(){
    const petId = sessionStorage.getItem('petId');
    const url = `${apiUrl.key}prescriptions/${petId}`;
    return this.http.get<any>(url);
  }

  getPet(){
    const petId = sessionStorage.getItem('petId');
    const url = `${apiUrl.key}pets/${petId}`;
    return this.http.get<any>(url);
  }

  getPetsTherapies(){
    const petId = sessionStorage.getItem('petId');
    const url = `${apiUrl.key}therapies/${petId}`;
    return this.http.get<void>(url);
  }

  getPetsVisits(){
    const petId = sessionStorage.getItem('petId');
    const url = `${apiUrl.key}visit/${petId}`;
    return this.http.get<void>(url);
  }
  getVets() {
    const url = `${apiUrl.key}vet`;
    return this.http.get<any>(url);
  }
  getTherapies() {
    const url = `${apiUrl.key}therapies`;
    return this.http.get<any>(url);
  }
  getPrescriptions() {
    const url = `${apiUrl.key}prescriptions`;
    return this.http.get<any>(url);
  }
  getVisitDetails() {
    const petId = sessionStorage.getItem('petId');
    const visitId = sessionStorage.getItem('visitId');
    const url = `${apiUrl.key}visit/${petId}/${visitId}`;
    return this.http.get<any>(url);
  }
  getPrescriptionDetails() {
    const petId = sessionStorage.getItem('petId');
    const prescriptionId = sessionStorage.getItem('prescriptionId');
    const url = `${apiUrl.key}prescriptions/${petId}/${prescriptionId}`;
    return this.http.get<any>(url);
  }
  getTherapiesDetails() {
    const petId = sessionStorage.getItem('petId');
    const therapyId = sessionStorage.getItem('therapyId');
    const url = `${apiUrl.key}therapies/${petId}/${therapyId}`;
    return this.http.get<any>(url);
  }

  scheduleAnVisit(data: any) {
    const url = `${apiUrl.key}visit`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('Visit scheduled sucessfully');
        this.router.navigate(['/home/']);
      },
      (error) => {
        alert('Cant create an appointment');
      }
    );
  }

  addAppointmentDetails(data: any) {
    const petId = sessionStorage.getItem('petId');
    const visitId = sessionStorage.getItem('visitId');
    const url = `${apiUrl.key}visit/${petId}/${visitId}`;
    this.http.patch<void>(url, data).subscribe(
      () => {
        alert('Visit updated  sucessfully');
        
      },
      (error) => {
        alert('Cant create an appointment');
      }
    );
  }

}
