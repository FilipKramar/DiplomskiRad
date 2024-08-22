import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TherapiesdetailComponent } from './therapiesdetail.component';

describe('TherapiesdetailComponent', () => {
  let component: TherapiesdetailComponent;
  let fixture: ComponentFixture<TherapiesdetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TherapiesdetailComponent]
    });
    fixture = TestBed.createComponent(TherapiesdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
