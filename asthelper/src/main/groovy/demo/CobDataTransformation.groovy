package demo

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

import java.lang.reflect.Modifier

@GroovyASTTransformation
class CobDataTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        def classNode = nodes[1]

        if(!classNode.getMethod('getMagicNumber', new Parameter[0])) {
            def code = new ReturnStatement(new ConstantExpression(42))

            def method = new MethodNode('getMagicNumber',
                    Modifier.PUBLIC,
                    ClassHelper.make(Integer),
                    new Parameter[0],
                    null,
                    code)

            classNode.addMethod(method)
        }
    }
}
