import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitOutputComponent } from './submit-output.component';

describe('SubmitOutputComponent', () => {
  let component: SubmitOutputComponent;
  let fixture: ComponentFixture<SubmitOutputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmitOutputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitOutputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
