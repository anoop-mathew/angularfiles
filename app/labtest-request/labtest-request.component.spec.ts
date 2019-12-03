import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LabtestRequestComponent } from './labtest-request.component';

describe('LabtestRequestComponent', () => {
  let component: LabtestRequestComponent;
  let fixture: ComponentFixture<LabtestRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LabtestRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LabtestRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
