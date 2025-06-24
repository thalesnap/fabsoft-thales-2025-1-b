import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormPlaylistComponent } from './form-playlist.component';

describe('FormPlaylistComponent', () => {
  let component: FormPlaylistComponent;
  let fixture: ComponentFixture<FormPlaylistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormPlaylistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormPlaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
