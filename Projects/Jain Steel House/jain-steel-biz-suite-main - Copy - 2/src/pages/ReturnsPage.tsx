import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { RotateCcw } from "lucide-react";

export default function ReturnsPage() {
  return (
    <div className="space-y-4">
      <p className="text-muted-foreground text-sm">Process item returns and refunds</p>
      <Card className="shadow-surface">
        <CardContent className="flex flex-col items-center justify-center py-16">
          <RotateCcw className="w-12 h-12 text-muted-foreground/40 mb-4" />
          <h3 className="font-heading font-semibold text-lg">Returns Module</h3>
          <p className="text-muted-foreground text-sm mt-1">Returns can be processed from individual bills. Coming soon as a dedicated module.</p>
        </CardContent>
      </Card>
    </div>
  );
}
