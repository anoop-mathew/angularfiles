import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMedicineRequestComponent } from './add-medicine-request.component';

describe('AddMedicineRequestComponent', () => {
  let component: AddMedicineRequestComponent;
  let fixture: ComponentFixture<AddMedicineRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMedicineRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMedicineRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
