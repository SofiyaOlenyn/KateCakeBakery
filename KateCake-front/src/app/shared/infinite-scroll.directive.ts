import {Directive, EventEmitter, OnInit, Output} from '@angular/core';
import {filter, map, scan} from 'rxjs/operators';
import {fromEvent} from 'rxjs';

interface ScrollEvent {
  currYOffset: number;
  canProceed: boolean;
  originalEvent: Event;
}

@Directive({
  selector: '[appInfiniteScroll]',
})
export class InfiniteScrollDirective implements OnInit {
  @Output() loadMore: EventEmitter<Event> = new EventEmitter<Event>();

  ngOnInit(): void {
    const seed: ScrollEvent = {currYOffset: 0, canProceed: true, originalEvent: null};

    fromEvent(window, 'scroll')
      .pipe(
        map(event => ({currYOffset: window.pageYOffset, canProceed: null, originalEvent: event})),
        scan((acc: ScrollEvent, event: ScrollEvent) => Object.assign(
          event,
          {canProceed: event.currYOffset > acc.currYOffset}),
          seed),
        filter(e => this.shouldTrigger(e)))
      .subscribe(e => this.loadMore.emit(e.originalEvent));
  }

  private shouldTrigger(event: ScrollEvent): boolean {
    const {scrollHeight} = window.document.body;
    const {pageYOffset, innerHeight} = window;
    return event.canProceed && (pageYOffset + innerHeight >= scrollHeight - 100);
  }
}
