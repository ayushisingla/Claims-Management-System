import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberdetailsModuleComponent } from './memberdetails-module.component';

describe('MemberdetailsModuleComponent', () => {
  let component: MemberdetailsModuleComponent;
  let fixture: ComponentFixture<MemberdetailsModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MemberdetailsModuleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberdetailsModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
