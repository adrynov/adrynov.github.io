function run() {
    const images = document.getElementsByTagName('img');
    const srs = Array.from(images, img => img.src);
    // console.log(srs);
}

document.addEventListener('DOMContentLoaded', () => run());

const module = {
    x: 42,
    getX: function() {
        return this.x;
    }
};

const unbounded = module.getX;
console.log(unbounded());

const bounded = module.getX.bind(module);
console.log(bounded());