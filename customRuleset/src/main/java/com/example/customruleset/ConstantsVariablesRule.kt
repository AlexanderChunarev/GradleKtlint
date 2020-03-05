package com.example.customruleset

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.psiUtil.children

class ConstantsVariablesRule : Rule("upper-case-const-name") {
    private val regex = "[a-z]+".toRegex()

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtNodeTypes.FOR) {
            node.children()
                .first { it.elementType == KtTokens.IDENTIFIER }
                .takeIf { it.text.contains(regex) }
                ?.let {
                    emit(
                        it.startOffset,
                        "Const variable ${it.text} should be declared by uppercase letters",
                        false
                    )
                }
        }
    }
}
