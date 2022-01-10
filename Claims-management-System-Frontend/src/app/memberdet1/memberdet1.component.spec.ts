import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Memberdet1Component } from './memberdet1.component';

describe('Memberdet1Component', () => {
  let component: Memberdet1Component;
  let fixture: ComponentFixture<Memberdet1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Memberdet1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Memberdet1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
