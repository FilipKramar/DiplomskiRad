import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VetappointmentsComponent } from './vetappointments.component';

describe('VetappointmentsComponent', () => {
  let component: VetappointmentsComponent;
  let fixture: ComponentFixture<VetappointmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VetappointmentsComponent]
    });
    fixture = TestBed.createComponent(VetappointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
