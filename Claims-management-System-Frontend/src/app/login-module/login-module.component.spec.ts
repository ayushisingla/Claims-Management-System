import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginModuleComponent } from './login-module.component';

describe('LoginModuleComponent', () => {
  let component: LoginModuleComponent;
  let fixture: ComponentFixture<LoginModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginModuleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
