import { NgModule } from "@angular/core";

import { EllipsisPipe } from "./ellipsis.pipe";

/**
 * Pipes module.
 */
@NgModule({
  declarations: [EllipsisPipe],
  exports: [EllipsisPipe],
})
export class PipesModule {}
