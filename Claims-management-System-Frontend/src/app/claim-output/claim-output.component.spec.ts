import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimOutputComponent } from './claim-output.component';

describe('ClaimOutputComponent', () => {
  let component: ClaimOutputComponent;
  let fixture: ComponentFixture<ClaimOutputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClaimOutputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimOutputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
