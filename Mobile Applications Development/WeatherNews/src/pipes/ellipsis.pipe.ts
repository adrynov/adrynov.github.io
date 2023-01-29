import { Pipe } from "@angular/core";

/**
 * Allows to crop long text.
 */
@Pipe({
  name: "ellipsis",
})
export class EllipsisPipe {
  transform(val: string, args) {
    if (args === undefined) {
      return val;
    }

    if (val.length > args) {
      return val.substring(0, args) + "...";
    } else {
      return val;
    }
  }
}
