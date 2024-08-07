import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterpetComponent } from './registerpet.component';

describe('RegisterpetComponent', () => {
  let component: RegisterpetComponent;
  let fixture: ComponentFixture<RegisterpetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterpetComponent]
    });
    fixture = TestBed.createComponent(RegisterpetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
