package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<Object, Object> {

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public Creator handleRequest(Object input, Context context) {
        Creator creator = new Creator("Victor Mwangi", "Localstack", "Java", "Docker", "Gradle");
        context.getLogger().log("You provided: " + input);
        return creator;
    }
}
