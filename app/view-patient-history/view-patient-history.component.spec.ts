import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPatientHistoryComponent } from './view-patient-history.component';

describe('ViewPatientHistoryComponent', () => {
  let component: ViewPatientHistoryComponent;
  let fixture: ComponentFixture<ViewPatientHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPatientHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPatientHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
