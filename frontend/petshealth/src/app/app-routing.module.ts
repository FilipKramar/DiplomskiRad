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

export const routes: Routes = [
  {
    path: '',
    component: StartPageComponent,
    children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
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
          { path: 'therapies', component: TherapiesComponent }
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
