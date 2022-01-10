import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { AppRoutingModule , routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { MemberdetailsModuleComponent } from './memberdetails-module/memberdetails-module.component';
import { Memberdet1Component } from './memberdet1/memberdet1.component';
import { ClaimInputComponent } from './claim-input/claim-input.component';
import { ClaimOutputComponent } from './claim-output/claim-output.component';
import { SubmitInputComponent } from './submit-input/submit-input.component';
import { SubmitOutputComponent } from './submit-output/submit-output.component';
import { InterceptorServiceService } from './interceptor-service.service';
import { AuthGuardGuard } from './auth-guard.guard';
import { ErrormsgComponent } from './errormsg/errormsg.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    MemberdetailsModuleComponent,
    Memberdet1Component,
    ClaimInputComponent,
    ClaimOutputComponent,
    SubmitInputComponent,
    SubmitOutputComponent,
    ErrormsgComponent,
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass:InterceptorServiceService,multi:true},AuthGuardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
