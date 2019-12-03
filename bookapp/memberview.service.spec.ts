import { TestBed } from '@angular/core/testing';

import { MemberviewService } from './memberview.service';

describe('MemberviewService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MemberviewService = TestBed.get(MemberviewService);
    expect(service).toBeTruthy();
  });
});
