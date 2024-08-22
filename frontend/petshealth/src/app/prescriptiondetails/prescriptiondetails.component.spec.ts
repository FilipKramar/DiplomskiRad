import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptiondetailsComponent } from './prescriptiondetails.component';

describe('PrescriptiondetailsComponent', () => {
  let component: PrescriptiondetailsComponent;
  let fixture: ComponentFixture<PrescriptiondetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrescriptiondetailsComponent]
    });
    fixture = TestBed.createComponent(PrescriptiondetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
