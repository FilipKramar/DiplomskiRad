import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartPageComponent } from './start-page/start-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { MainpageComponent } from './mainpage/mainpage.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SelectpetComponent } from './selectpet/selectpet.component';
import { RegisterpetComponent } from './registerpet/registerpet.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PrescriptionsComponent } from './prescriptions/prescriptions.component';
import { TherapiesComponent } from './therapies/therapies.component';
import { VisitComponent } from './visit/visit.component';
import { PrescriptiondetailsComponent } from './prescriptiondetails/prescriptiondetails.component';
import { TherapiesdetailComponent } from './therapiesdetail/therapiesdetail.component';
import { VisitdetailComponent } from './visitdetail/visitdetail.component';
import { VetloginComponent } from './vetlogin/vetlogin.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { VetappointmentsComponent } from './vetappointments/vetappointments.component';
import { AppointmentdetailsComponent } from './appointmentdetails/appointmentdetails.component';

export const routes: Routes = [
  {
    path: '',
    component: StartPageComponent,
    children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'vet', component: VetloginComponent },
    ]
  },
  {
    path: 'home',
    component: MainpageComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        children: [
          { path: '', component: SelectpetComponent },
          { path: 'register', component: RegisterpetComponent },
        ],
      },
      {
        path: '',
        component: HomepageComponent,
        children: [
          { path: 'prescription', component: PrescriptionsComponent },
          { path: 'therapies', component: TherapiesComponent },
          { path: 'visit', component: VisitComponent },
          { path: 'prescriptiondetails', component: PrescriptiondetailsComponent },
          { path: 'therapiesdetails', component: TherapiesdetailComponent },
          { path: 'visitdetails', component: VisitdetailComponent },
          { path: 'appointment', component: AppointmentComponent },
          { path: 'vetappointment', component: VetappointmentsComponent },
          { path: 'appointmentdetails', component: AppointmentdetailsComponent }        
        
        ],
      }
      ],
      }
    ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
