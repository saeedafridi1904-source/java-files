/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // Edge case: if classFunction is not a function or is null/undefined, it can't have a prototype
    if (classFunction === null || classFunction === undefined || typeof classFunction !== 'function') {
        return false;
    }

    // Edge case: if obj is null or undefined, it cannot access any methods
    if (obj === null || obj === undefined) {
        return false;
    }

    // Get the initial prototype of the object (handles primitives like 5 converting to Number)
    let currentPrototype = Object.getPrototypeOf(obj);

    // Explicitly traverse the entire prototype chain step by step
    while (currentPrototype !== null) {
        // If we find a match with the class's prototype, return true
        if (currentPrototype === classFunction.prototype) {
            return true;
        }
        // Move one step up the prototype chain
        currentPrototype = Object.getPrototypeOf(currentPrototype);
    }

    // If we reached the end of the chain (null) without finding a match
    return false;
};