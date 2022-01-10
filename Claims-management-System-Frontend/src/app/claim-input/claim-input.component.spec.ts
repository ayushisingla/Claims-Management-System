import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimInputComponent } from './claim-input.component';

describe('ClaimInputComponent', () => {
  let component: ClaimInputComponent;
  let fixture: ComponentFixture<ClaimInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClaimInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
