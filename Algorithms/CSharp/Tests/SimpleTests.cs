using CSharp;

namespace Tests;

public class SimpleTests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void FindMaximum()
    {
        Assert.That(SimpleLogic.findMaximum(1, 2, 3), Is.EqualTo(3));
        Assert.That(SimpleLogic.findMaximum(8, 8, 1), Is.EqualTo(8));
        Assert.That(SimpleLogic.findMaximum(3, 2, 3), Is.EqualTo(3));
        Assert.That(SimpleLogic.findMaximum(1, 2, 3), Is.EqualTo(3));
        Assert.That(SimpleLogic.findMaximum(1, 1, 9), Is.EqualTo(9));
        Assert.That(SimpleLogic.findMaximum(1, 9, 8), Is.EqualTo(9));
    }
}