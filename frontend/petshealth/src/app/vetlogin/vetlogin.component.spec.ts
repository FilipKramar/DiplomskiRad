import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VetloginComponent } from './vetlogin.component';

describe('VetloginComponent', () => {
  let component: VetloginComponent;
  let fixture: ComponentFixture<VetloginComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VetloginComponent]
    });
    fixture = TestBed.createComponent(VetloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
